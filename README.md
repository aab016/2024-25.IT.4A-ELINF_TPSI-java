## Getting Started

## jmap

As an alternative to gdb for heap memory dumping you can use `jmap -dump:format=b,file=heap.hprof <PID>`

## PasswordBreaker

`javac *.java`
`java PasswordBreaker > sysout.log`
`cat sysout.log | sort | uniq -c | sort > sysout.log.random`
