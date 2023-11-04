# Lab report 3 
## LAB 3 Bug

### ListExamples filter bug
* Failure inducing input, as jUnit test
```java
    @Test
    public void testFilter(){
        List<String> ans  = new ArrayList<>();
        ans.addAll(List.of("Hello","Cat","Bat","mat","Fat","Dat"));
        List<String> rans =  ListExamples.filter(ans, new StringChecker() {

            @Override
            public boolean checkString(String s) {
                // TODO Auto-generated method stub
                if(s.charAt(0) == Character.toUpperCase(s.charAt(0))){
                    return true;
                }
                return false;
            }
        });
        assertEquals(List.of("Hello","Cat","Bat","Fat","Dat"),rans);
    }
```
* non-failure inducing input
```java
    @Test
    public void testFilter(){
        List<String> ans  = new ArrayList<>();
        ans.addAll(List.of("Hello","cat","bat","mat","fat","dat"));
        List<String> rans =  ListExamples.filter(ans, new StringChecker() {

            @Override
            public boolean checkString(String s) {
                // TODO Auto-generated method stub
                if(s.charAt(0) == Character.toUpperCase(s.charAt(0))){
                    return true;
                }
                return false;
            }
        });
        assertEquals(List.of("Hello"),rans);
    }
```
* Test Output from above \
***Test failure output*** \
***Non test failure input***
* Code Before and After
```java
  // Returns a new list that has all the elements of the input list for which
  // the StringChecker returns true, and not the elements that return false, in
  // the same order they appeared in the input list;
  static List<String> filter(List<String> list, StringChecker sc) {
    List<String> result = new ArrayList<>();
    for(String s: list) {
      if(sc.checkString(s)) {
        result.add(0,s);
      }
    }
    return result;
  }
```
```java
  // Returns a new list that has all the elements of the input list for which
  // the StringChecker returns true, and not the elements that return false, in
  // the same order they appeared in the input list;
  static List<String> filter(List<String> list, StringChecker sc) {
    List<String> result = new ArrayList<>();
    for(String s: list) {
      if(sc.checkString(s)) {
        result.add(s); //should be added at the end of the list, not beginning of the list
      }
    }
    return result;
  }
```
* Description of the fix \
before the fix the code above would take the matching string and appended to the begging of the list as it was inserting it into the zero index position. this of course was a bug as the code above should insert the string at the end as the strings need to be in the same order as they appear. This is why changing the code to `result.add(s)` fixed the bug as it correctly appends the strings into the list in the order they appear in.


## Part 2 Researching Commands: grep

* --include and --exclude grep options
```zsh
andrewpegg@Andrews-MacBook-Pro docsearch % grep -ir --include='*2180*.txt' basepair ./technical/biomed
./technical/biomed/1471-2180-1-26.txt:          basepairs (bp) upstream of the start codon of the gene
./technical/biomed/1471-2180-2-13.txt:          basepair insertions were introduced at position -35
./technical/biomed/1471-2180-2-13.txt:          observed of three to five basepairs in size for each DNA
andrewpegg@Andrews-MacBook-Pro docsearch %
```
```zsh
andrewpegg@Andrews-MacBook-Pro docsearch % grep -ir --exclude='*2180*.txt' basepair ./technical/biomed
./technical/biomed/ar319.txt:        antigen; kb = kilobasepairs; LOD = logarithm of odds ratio;
./technical/biomed/ar319.txt:          interval of approximately 0.96 megabasepairs.
./technical/biomed/1471-2105-3-30.txt:          with 80 or more basepairs masked by the Tandem Repeat
./technical/biomed/1471-2105-3-30.txt:        and concatenating 100 basepair chunks from genomic
./technical/biomed/1471-2091-4-5.txt:          release a 1426 basepair (bp) PAI-1 coding sequence, which
./technical/biomed/1471-2105-3-37.txt:          basepairs 3' of the AP-site. This redundancy of binding
./technical/biomed/1471-2164-3-7.txt:          MeasuredHeight / ((CalculatedBasePairs / - Denominator) +
./technical/biomed/1471-2105-3-2.txt:            nearly 98% of the basepairings in our 16S and 23S rRNA
./technical/biomed/1471-2164-2-7.txt:          identity to the 69 basepairs of
andrewpegg@Andrews-MacBook-Pro docsearch %
```
The --include and --exlcude provide a way to match filenames and paths with a pattern, which allows more control of what files are scanned with grep. This helpful when with running with recursive grep option as as it allows to you specify what file extension to search or even more specify a pattern for filenames themselves, or as shown above you can do both at the same time.
