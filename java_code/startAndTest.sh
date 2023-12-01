echo "starting java code wtih arguments $1 $2"
output=`java Main.java $1 $2`
if [ "$output" = "$3" ]; then
    echo "tested passed"
else
    echo "tested failed: expected $3 but got $output"
fi
