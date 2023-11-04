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
***failure indcuing input test output*** and ***non-failure inducing input test output***

![test output](https://github.com/andrewcomputsci2019/cse15l-lab-reports/assets/54915639/ecba8c1f-85e9-4769-a865-aad789c2864c)
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
The `--include` and `--exclude` provide a way to match filenames and extensions with a pattern, which allows more control of what files are scanned with grep. This helpful when with running with recursive grep option as as it allows to you specify what file extension to search or even pattern for filenames themselves, or as shown above you can do both at the same time by giving a specific pattern of the filename and file-extension you are interested or not interested in scanning. This can be useful for example when a directory may contain binary files that you don't want to scan. All information was obtained from the man page for grep
* `-w` option
```sh
$ grep -rwi -m 15  "taxes" ./technical/government/
./technical/government/About_LSC/commission_report.txt:taxes for H-2A workers. See March Testimony at 157 (testimony of
./technical/government/Env_Prot_Agen/jeffordslieberm.txt:of Distorting Taxes" Journal of Policy Analysis and Management
./technical/government/Gen_Account_Office/Sept14-2002_d011070.txt:additional taxes are being assessed within 5 to 8 months, much
./technical/government/Gen_Account_Office/Statements_Feb28-1997_volume.txt:242. Individual income taxes, corporation income taxes, social
./technical/government/Gen_Account_Office/Statements_Feb28-1997_volume.txt:insurance taxes and contributions,37 excise taxes, estate and gift
./technical/government/Gen_Account_Office/Statements_Feb28-1997_volume.txt:taxes, and customs duties.--Taxes (including customs duties) are
./technical/government/Gen_Account_Office/Statements_Feb28-1997_volume.txt:compel payment. In broad terms, taxes are "the price we pay for
./technical/government/Gen_Account_Office/Statements_Feb28-1997_volume.txt:243. All excise taxes, like other taxes, are classified as
./technical/government/Gen_Account_Office/Statements_Feb28-1997_volume.txt:resulting in nonexchange revenue. Some excise taxes (considered to
./technical/government/Gen_Account_Office/Statements_Feb28-1997_volume.txt:be benefit taxes) are levied on bases that are related to the use
./technical/government/Gen_Account_Office/Statements_Feb28-1997_volume.txt:taxes are levied on bases related to a cause of some damage and are
./technical/government/Gen_Account_Office/Statements_Feb28-1997_volume.txt:indirect and disproportionate. Moreover, these excise taxes, like
./technical/government/Gen_Account_Office/Statements_Feb28-1997_volume.txt:other taxes, are determined through the exercise of the power of
./technical/government/Gen_Account_Office/Statements_Feb28-1997_volume.txt:the Government to compel payment. Therefore, like other taxes, they
./technical/government/Gen_Account_Office/Statements_Feb28-1997_volume.txt:insurance taxes, like other taxes, are determined through the
./technical/government/Gen_Account_Office/Statements_Feb28-1997_volume.txt:taxes are subject to them as a byproduct of their decision to enter
./technical/government/Gen_Account_Office/Statements_Feb28-1997_volume.txt:other retirement plans. "Social insurance" taxes and contributions
./technical/government/Gen_Account_Office/Statements_Feb28-1997_volume.txt:246. Social insurance taxes and contributions paid by Federal
./technical/government/Gen_Account_Office/d01376g.txt:and paying taxes.
./technical/government/Gen_Account_Office/d01591sp.txt:by 2030, there will be only about 2 workers paying taxes to support
./technical/government/Gen_Account_Office/d01591sp.txt:what is left over from personal income after taxes and personal
./technical/government/Gen_Account_Office/d01591sp.txt:state, and local taxes as well as Social Security and Medicare
./technical/government/Gen_Account_Office/d01591sp.txt:payroll taxes are paid. The NIPA personal saving rate is calculated
./technical/government/Gen_Account_Office/d01591sp.txt:realized gains do not count as personal income, but any taxes paid
./technical/government/Gen_Account_Office/d01591sp.txt:taxes and personal spending, FFA measures saving as the net
./technical/government/Gen_Account_Office/d01591sp.txt:inflation and taxes.13
./technical/government/Gen_Account_Office/d01591sp.txt:realized gains do not count as personal income, but any taxes paid
./technical/government/Gen_Account_Office/d01591sp.txt:Family income before taxes
./technical/government/Gen_Account_Office/d01591sp.txt:cash income before taxes for the calendar year preceding the
./technical/government/Gen_Account_Office/d01591sp.txt:sources-before taxes and Medicare premiums. This retirement income
./technical/government/Gen_Account_Office/d01591sp.txt:Social Security taxes, other taxes, or working expenses that will
./technical/government/Gen_Account_Office/d01591sp.txt:relatively fewer workers to pay taxes to finance Social Security
./technical/government/Gen_Account_Office/d01591sp.txt:that payroll taxes of current workers are used to pay retirement,
./technical/government/Gen_Account_Office/d01591sp.txt:Security now collects more in payroll taxes than it pays in
./technical/government/Gen_Account_Office/d0269g.txt:individual taxes, $3.76 billion in Goods and Services Tax revenue,
./technical/government/Gen_Account_Office/og96038.txt:Federal excise taxes remain at the current levels, tax revenues
./technical/government/Media/Anthem_Payout.txt:home repairs or paying property taxes.
./technical/government/Media/Helping_Out.txt:admit that even though my taxes are relatively simple and I took a
./technical/government/Media/Legal_system_fails_poor.txt:regarding taxes or bankruptcy.
./technical/government/Media/New_funding_sources.txt:with income taxes, things that we take for granted." Rubin has held
./technical/government/Media/The_Columbian.txt:program because taxes and accounting costs would eat away the money
./technical/government/Post_Rate_Comm/Mitchell_RMVancouver.txt:such things as the payment of taxes, the need for a return on
```
```sh
$ grep -rwi "DNA replication" ./technical/biomed/
./technical/biomed/1471-2091-2-13.txt:        proteins are their expression during DNA replication [ 1 ]
./technical/biomed/1471-2091-3-13.txt:        DNA replication intermediates, but much weaker relaxation
./technical/biomed/1471-2091-3-13.txt:        plasmid DNA replication intermediates [ 19 ] . Removal of
./technical/biomed/1471-2091-3-23.txt:        DNA replication. Nearly all eukaryotic genes transcribed by
./technical/biomed/1471-2091-3-23.txt:        binding proteins in eukaryotic DNA replication is not well
./technical/biomed/1471-2091-3-23.txt:        sequences essential for DNA replication has been elusive so
./technical/biomed/1471-2091-3-23.txt:        eukaryotic DNA replication [ 10 ] . However, two
./technical/biomed/1471-2091-3-23.txt:        for initiation of DNA replication have also been reported [
./technical/biomed/1471-2091-3-23.txt:        specific DNA sequences. In eukaryotic DNA replication,
./technical/biomed/1471-2091-3-23.txt:        for DNA replication. The fact that it binds to yeast ACS
./technical/biomed/1471-2091-3-23.txt:        DNA replication.
./technical/biomed/1471-2121-2-11.txt:          activate chromosomal DNA replication by interacting with
./technical/biomed/1471-2121-2-11.txt:          for BLM during DNA replication. One study on chromosome
./technical/biomed/1471-2121-2-11.txt:          during DNA replication
./technical/biomed/1471-2121-2-11.txt:          requirement in a reconstituted DNA replication system [
./technical/biomed/1471-2121-2-11.txt:          structures that occur during DNA replication. As both the
./technical/biomed/1471-2156-4-9.txt:          elimination of E2F during DNA replication requires
./technical/biomed/1471-2156-4-9.txt:        prior to significant DNA replication. In contrast, we found
./technical/biomed/1471-2156-4-9.txt:        limit DNA replication both in mammalian cells [ 16 ] and in
./technical/biomed/1471-2156-4-9.txt:        on DNA replication and indicates that we still have much to
./technical/biomed/1471-2164-3-15.txt:        initiation of DNA replication.
./technical/biomed/1471-2164-3-18.txt:          trafficking, DNA replication, metal ion metabolism and
./technical/biomed/1471-2180-3-10.txt:        known or predicted to be involved in DNA replication.
./technical/biomed/1471-2202-4-6.txt:        suspected role of lamins in DNA replication [ 8 ] . Others
./technical/biomed/1471-2202-4-6.txt:        organization of DNA replication sites [ 4 ] , it would not
./technical/biomed/1471-2202-4-6.txt:        DNA replication and the cell cycle [ 8 ] , and the sharing
./technical/biomed/1471-2334-2-7.txt:        viral DNA replication. HSV with TK mutations may impair
./technical/biomed/1471-2334-2-7.txt:          strain may occur during viral DNA replication [ 1 ] . The
./technical/biomed/1471-2407-1-6.txt:        tightly to DNA and to proteins involved in DNA replication
./technical/biomed/1471-2407-1-6.txt:        and repair. It is essential for DNA replication and is
./technical/biomed/1472-6807-3-1.txt:        DNA replication, addition of polyA tails to mRNA, addition
./technical/biomed/1475-2875-1-5.txt:          parasite DNA replication. These authors introduced the
./technical/biomed/1476-4598-1-3.txt:          polymerase sigma, and plays a role in DNA replication and
./technical/biomed/1476-4598-1-3.txt:        segregation by coordinating between DNA replication and
./technical/biomed/ar321.txt:        structure [ 10]. It plays key roles in DNA replication,
./technical/biomed/ar774.txt:        Although it may also participate in DNA replication and RNA
./technical/biomed/bcr284.txt:          induced a dose-dependent block in DNA replication on both
./technical/biomed/bcr284.txt:          related to the general patterns of DNA replication in
./technical/biomed/bcr284.txt:        and genes for DNA replication and repair enzymes and
./technical/biomed/gb-2002-3-12-research0087.txt:          DNA replication-related-element binding factor (DREF). At
./technical/biomed/gb-2002-3-12-research0087.txt:          genes involved in DNA replication and cell proliferation,
./technical/biomed/gb-2002-3-4-research0019.txt:          CDC5 (mitotic DNA replication) and 
./technical/biomed/gb-2003-4-7-r46.txt:          U118), 'DNA replication' (30,33), 'Mitosis' (28,37),
```
The `-w` option tells grep to only match with complete words so in the above case DNA replication only matches with exactly DNA replication and not DNA replications or DNA's replication, etc. This is helpful if you only want to match with specific strings and not sub-strings. For example, if your are searching for the number of times a is used as a determiner, then searching without -w would not be helpful as grep will match with any word that contains an a and not just an a by itself. All information was obtained from the man page for grep

* `-L` and `-v`
```
$ grep -Lri "base pair" ./technical/biomed/ | wc -l
763
```
```
$ grep -riv "base pair" ./technical/biomed/ | wc -l
490445
```
The `-L` and `-v` options are inverse selectors meaning that something matches if it does not match the given search pattern, differences do emerge among `-L` and `-v` as `-L` returns files that did not match and `-v` returns lines that did not match. This is incredibly helpful if you want to find files, or lines of text, that do not contain a certain pattern, for example maybe you want to search for all files or lines inside a program that don't contain a certain variable. All information was obtained from the man page for grep

* `-E / --extended-regexp`
```
$ grep -ro -m 1  --extended-regexp "\b[a-z|A-Z]{4}\b" ./technical/911report/
./technical/911report/chapter-1.txt:HAVE
./technical/911report/chapter-1.txt:SOME
./technical/911report/chapter-10.txt:were
./technical/911report/chapter-11.txt:this
./technical/911report/chapter-11.txt:have
./technical/911report/chapter-11.txt:that
./technical/911report/chapter-11.txt:with
./technical/911report/chapter-12.txt:WHAT
./technical/911report/chapter-13.1.txt:Cold
./technical/911report/chapter-13.2.txt:have
./technical/911report/chapter-13.3.txt:wgbh
./technical/911report/chapter-13.3.txt:html
./technical/911report/chapter-13.4.txt:knew
./technical/911report/chapter-13.4.txt:each
./technical/911report/chapter-13.4.txt:from
./technical/911report/chapter-13.4.txt:anti
./technical/911report/chapter-13.5.txt:Mani
./technical/911report/chapter-13.5.txt:last
./technical/911report/chapter-2.txt:year
./technical/911report/chapter-3.txt:kind
./technical/911report/chapter-5.txt:AIMS
./technical/911report/chapter-6.txt:FROM
./technical/911report/chapter-7.txt:Asia
./technical/911report/chapter-8.txt:were
./technical/911report/chapter-9.txt:last
./technical/911report/chapter-9.txt:best
./technical/911report/chapter-9.txt:hope
./technical/911report/preface.txt:this
./technical/911report/preface.txt:that
./technical/911report/preface.txt:flow
./technical/911report/preface.txt:from
```
```
$ grep -ro -m 2  --extended-regexp "[a-z]+,[' '][a-z]+" ./technical/911report/
./technical/911report/chapter-1.txt:owers, the
./technical/911report/chapter-1.txt:irginia, to
./technical/911report/chapter-1.txt:iver, the
./technical/911report/chapter-1.txt:venue, people
./technical/911report/chapter-1.txt:airport, weather
./technical/911report/chapter-1.txt:mari, who
./technical/911report/chapter-10.txt:occurred, while
./technical/911report/chapter-10.txt:itself, a
./technical/911report/chapter-11.txt:narrative, we
./technical/911report/chapter-11.txt:event, of
./technical/911report/chapter-11.txt:course, a
./technical/911report/chapter-12.txt:become, beyond
./technical/911report/chapter-12.txt:doubt, the
./technical/911report/chapter-12.txt:ongress, both
./technical/911report/chapter-13.1.txt:configured, the
./technical/911report/chapter-13.1.txt:adversaries, the
./technical/911report/chapter-13.2.txt:simplicity, we
./technical/911report/chapter-13.2.txt:materials, including
./technical/911report/chapter-13.3.txt:spread, see
./technical/911report/chapter-13.3.txt:urope, trans
./technical/911report/chapter-13.4.txt:reports, interrogations
./technical/911report/chapter-13.4.txt:ethnicity, see
./technical/911report/chapter-13.5.txt:custody, he
./technical/911report/chapter-13.5.txt:tates, in
./technical/911report/chapter-2.txt:awahiri, arranged
./technical/911report/chapter-2.txt:authority, but
./technical/911report/chapter-2.txt:awahiri, nor
./technical/911report/chapter-3.txt:terrorism, and
./technical/911report/chapter-3.txt:chapter, we
./technical/911report/chapter-5.txt:asri, also
./technical/911report/chapter-5.txt:structure, al
./technical/911report/chapter-6.txt:successes, the
./technical/911report/chapter-6.txt:erger, ensured
./technical/911report/chapter-7.txt:ihdhar, and
./technical/911report/chapter-7.txt:identified, and
./technical/911report/chapter-8.txt:began, counterterrorism
./technical/911report/chapter-8.txt:ndeed, there
./technical/911report/chapter-9.txt:servants, especially
./technical/911report/chapter-9.txt:fire, police
./technical/911report/chapter-9.txt:service, and
./technical/911report/preface.txt:tates, the
./technical/911report/preface.txt:ongress, and
./technical/911report/preface.txt:happen, and
```
the `-E` or `--extended-regexp` allows grep to interpret extended regex patterns beyond just simple wild card pattern statements. As shown above this can be matching all 4 letter words or every occurrence of two words being separated by a comma. It goes with out saying how useful this can be in terms of searching through files and their stored content. A shining example of a use case for this option could a file that contains a dataset where each data-point is enclosed by some structured pattern, that can be matched with a regex, allowing for the data-points to be extraced into a file. All information was obtained from the man page for grep, and regex were created injunction with [regex101](https://regex101.com/)
