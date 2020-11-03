import pandas as pd
import dataframe
import csv

f = open("/home/kdg/바탕화면/hadoop-book/clothdata.csv",'r',encoding='utf-8')
file_name = csv.reader(f)


df = pd.DataFrame(file_name)
#del df["Title","Review Text","Positive Feedback Count","Division Name","DEpartment Name","Class Name"]
sort_data = df.drop(df.columns[[0,3,4,7,8,9,10]],axis = 'columns')

print(sort_data)

sort_data.to_csv("/home/kdg/바탕화면/hadoop-book/sortdata_1.csv",index=None, na_rep='NaN',encoding='utf-8')
