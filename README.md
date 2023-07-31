```bash
brew install gradle@7

gradle clean run
```

```bash
ab -n 25000 -c 100 -k http://localhost:8080/
This is ApacheBench, Version 2.3 <$Revision: 1843412 $>
Copyright 1996 Adam Twiss, Zeus Technology Ltd, http://www.zeustech.net/
Licensed to The Apache Software Foundation, http://www.apache.org/

Benchmarking localhost (be patient)
Completed 2500 requests
Completed 5000 requests
Completed 7500 requests
Completed 10000 requests
Completed 12500 requests
Completed 15000 requests
Completed 17500 requests
Completed 20000 requests
Completed 22500 requests
Completed 25000 requests
Finished 25000 requests


Server Software:        
Server Hostname:        localhost
Server Port:            8080

Document Path:          /
Document Length:        11 bytes

Concurrency Level:      100
Time taken for tests:   26.373 seconds
Complete requests:      25000
Failed requests:        0
Keep-Alive requests:    25000
Total transferred:      2875000 bytes
HTML transferred:       275000 bytes
Requests per second:    947.96 [#/sec] (mean)
Time per request:       105.490 [ms] (mean)
Time per request:       1.055 [ms] (mean, across all concurrent requests)
Transfer rate:          106.46 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   2.3      0      51
Processing:     1  105 104.3     41     723
Waiting:        0  104 103.4     40     722
Total:          1  105 104.2     41     723

Percentage of the requests served within a certain time (ms)
  50%     41
  66%    113
  75%    169
  80%    199
  90%    276
  95%    320
  98%    372
  99%    405
 100%    723 (longest request)
```