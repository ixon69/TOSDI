%~d0
cd %~dp0
java -Dtalend.component.manager.m2.repository="%cd%/../lib" -Xms256M -Xmx1024M -cp .;../lib/routines.jar;../lib/log4j-slf4j-impl-2.12.1.jar;../lib/log4j-api-2.12.1.jar;../lib/log4j-core-2.12.1.jar;../lib/ojdbc8-19.3.0.0.jar;../lib/talend-oracle-timestamptz.jar;../lib/crypto-utils.jar;../lib/jxl.jar;../lib/ini4j-0.5.1.jar;../lib/slf4j-api-1.7.25.jar;../lib/dom4j-2.1.1.jar;reservation_inpatient_0_4.jar; bucheon.reservation_inpatient_0_4.Reservation_Inpatient  --context=Default %*