# ClothProject
- 약 23000개의 Women's E-Commerce Clothing Reviews data를 고유 옷 ID별 평균평점으로 데이터를 정리하는 프로젝트 
## 1.Download 
- clothdata.csv를 다운받고 clothdata.py를 compile하세요.(

## 2.CheckData
- 정렬된 데이터 sortdata_1.csv를 확인하세요.

## 3.하둡 의사분산모드로 실행 후 데몬 실행
- HDFS 파일시스템 포맷,(HDFS,YARN,맵리듀스 데몬 구동)
 1. hdfs namenode -format
 2. start-dfs.sh
 3. start-yarn.sh
 4. mapred historyserver start


## 4.hdfs파일 시스템 경로설정(디렉토리 생성 및 로컬데이터 복사)
 1. hadoop fs -ls(디렉토리 확인)
 2. hadoop fs -mkdir -p {생성파일명}
 3. hadoop fs -put 로컬데이터경로 {새로만든 생성파일명}


## 5.pom.xml이 있는 디렉토리에서 maven compile 및 JAR파일 생성
 1. mvn compile
 2. mvn package -DskipTests

## 6.target디렉토리 폴더 내의 jar파일 생성 확인 후 잡 구동 명령어 실행 후 hdfs output 디렉토리 생성
- hadoop jar {생성된jar파일명}  v1.RatingAverage -conf conf/hadoop-cluster.xml input output

## 7.최종 리듀스 output파일을 확인하고 로컬시스템으로 복사(target디렉토리 내 데이터 파일 생성)
- hadoop fs -cat output/*
- hadoop fs -getmerge output local_output
