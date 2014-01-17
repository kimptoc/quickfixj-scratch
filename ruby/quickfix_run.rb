require 'java'


puts "Starting Acceptor: #{ARGV[0]}"

qf = Java::qftest.QuickfixBase.new.invoke(ARGV[0])

acc = Java::quickfix.SocketAcceptor.new qf.application, qf.store_factory, qf.settings, qf.log_factory, qf.message_factory

acc.start

puts "Starting Initiator: #{ARGV[1]}"

qf = Java::qftest.QuickfixBase.new.invoke(ARGV[1])

ini = Java::quickfix.SocketInitiator.new qf.application, qf.store_factory, qf.settings, qf.log_factory, qf.message_factory

ini.start