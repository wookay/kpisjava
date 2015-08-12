
- 빌드가 깨져 고쳐논 버전
- 원래 소스는 아래에 있음

* http://www.kpis.or.kr/st/StbCodeMapping/stbCodeInfo.do
```
의약품정보센터 홈페이지(www.kpis.or.kr)에 접속하지 않고, 공급업체가 사용하는 프로그램 내에서 정보센터가 제공하는 프로그램을 
호출하여 의약품표준코드 정보 등을 실시간으로 조회 또는 다운로드하여 실적보고업무 등에 활용할 수 있도록 제공하는 “웹서비스”입니다.
```


* 빌드
```
$ javac -cp `find * -name "*.jar" | tr "\n" ":"` -Xlint:unchecked -d . src/*.java
```


* 실행
```
$ java  -cp `find * -name "*.jar" | tr "\n" ":"` webservice/MedicinesInfoWS/ClientTest 1
log4j:WARN No appenders could be found for logger (org.apache.axis.i18n.ProjectResourceBundle).
log4j:WARN Please initialize the log4j system properly.
#################################################################
## 2015-08-12 getStandardCode 매핑 정보 시작
...
```
