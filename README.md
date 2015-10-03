# Dissertation-for-graduation
Subject: "“Evaluale similarities of a bus chain when enters a bus station or bus stop”. (App on desktop)
Programming language: Java(Swing).
Input: a file csv with structure below: 
          "deviceid"|"latitude"|"longitude"|"speed"|"satellite"|"lock"|"trktime"
          "121"|"10.75905"|"106.57781"|"0"|"7"|"1"|"2012-11-11 02:02:05"
          "181"|"10.75119"|"106.47897"|"24"|"7"|"1"|"2012-11-11 09:04:12"
          ...
Function: Read one or multi file input and export new file for calculating similarity(time series).
From file export, we use to show on chart, map and show similarities result between 2 bus.
Restrict: calculated time is long if we have multi file
          Only calculate similarity between 2 bus -> we'll have a number after all.
          Maybe hard to use.
