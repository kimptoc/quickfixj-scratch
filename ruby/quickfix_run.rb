require 'java'

java_import Java::qftest.QuickfixBase

["SocketAcceptor", "SocketInitiator", "SessionSettings", "Session"].each do |clazz|
	java_import "quickfix.#{clazz}"
end

java_import Java::quickfix.fix44.NewOrderSingle

["Currency","Symbol","Side","OrdType","ClOrdID","TransactTime","SenderCompID"].each do |clazz|
	java_import "quickfix.field.#{clazz}"
end

puts "Starting Acceptor: #{ARGV[0]}"

class MsgHandler
	def process(msg)
		puts "Ruby/MsgHandler - got a message:#{msg}"
	end
end

qf = QuickfixBase.new.invoke(ARGV[0], MsgHandler.new)

acc = SocketAcceptor.new qf.application, qf.store_factory, qf.settings, qf.log_factory, qf.message_factory

acc.start


puts "Starting Initiator: #{ARGV[1]}"

qf = QuickfixBase.new.invoke(ARGV[1], nil)

ini = SocketInitiator.new qf.application, qf.store_factory, qf.settings, qf.log_factory, qf.message_factory

ini.start


msg = NewOrderSingle.new

msg.set Currency.new "GBP"
msg.set Symbol.new "XS456"
msg.set Side.new Side::BUY
msg.set OrdType.new OrdType::MARKET
msg.set ClOrdID.new "yyy"
msg.set TransactTime.new java.util.Date.new
sender = qf.settings.get_string(qf.session_id, SessionSettings::SENDERCOMPID)
sender_field = SenderCompID.new sender
msg.header.field = sender_field
Session::sendToTarget msg, qf.session_id