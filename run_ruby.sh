#!/bin/sh

JRUBY_OPTIONS="-J-cp out/production/aa-quickfixj:config"
JRUBY_OPTIONS=${JRUBY_OPTIONS}:lib/quickfixj-all-1.5.3.jar
JRUBY_OPTIONS=${JRUBY_OPTIONS}:lib/jcl-over-slf4j-1.6.3.jar
JRUBY_OPTIONS=${JRUBY_OPTIONS}:lib/log4j-1.2.15.jar
JRUBY_OPTIONS=${JRUBY_OPTIONS}:lib/mina-core-1.1.7.jar
JRUBY_OPTIONS=${JRUBY_OPTIONS}:lib/mysql-connector-java-5.1.28-bin.jar
JRUBY_OPTIONS=${JRUBY_OPTIONS}:lib/proxool-0.9.1.jar
JRUBY_OPTIONS=${JRUBY_OPTIONS}:lib/proxool-cglib.jar
JRUBY_OPTIONS=${JRUBY_OPTIONS}:lib/slf4j-api-1.6.3.jar
JRUBY_OPTIONS=${JRUBY_OPTIONS}:lib/slf4j-log4j12-1.6.3.jar

jruby $JRUBY_OPTIONS ruby/quickfix_run.rb fix.in.config fix.out.config
