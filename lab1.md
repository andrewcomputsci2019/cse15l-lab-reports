# Lab Report 1 - Remote Acess and FileSystem
___
## **command `cd`**

### `cd` no arguments
```shell
[user@sahara ~]$ pwd
/home
[user@sahara ~]$ cd
[user@sahara ~]$
```
* working directory before was `/home`
* No noticeable difference occurred to the terminal or terminal prompt, and no directory change occurred. I tested this again in another directory and it quickly became apparent that `cd` with no arguments returns the user to the home directory.
* The output was not an error 

### `cd` with a path to a directory

```shell
[user@sahara ~]$ pwd
/home
[user@sahara ~]$ cd lecture1/
[user@sahara ~/lecture1]$ pwd
/home/lecture1
[user@sahara ~/lecture1]$
```
* working directory before was `/home`
* The location before the `$` signed changed from `~` to `~/lecture1`, this shows that terminal is now in the `lecture1` directory
in the user's home directory 
* the output is not an error 

### `cd` with a path to a file 

```shell
[user@sahara ~/lecture1]$ pwd
/home/lecture1
[user@sahara ~/lecture1]$ cd messages/de.txt 
bash: cd: messages/de.txt: Not a directory
[user@sahara ~/lecture1]$ 
```
* working directory before was` /home/lecture1`
* The command output was different from before, as it printed a string of text informing the user that `messages/de.txt` is not a directory, which is correct as `de.txt` is a text file within the messages directory.
* The output was an error, as cd is unable to change to a directory that is not a directory, such as passing a path to a file
___

## **`ls`**

### `ls` with no arguments

```shell
[user@sahara ~]$ pwd
/home
[user@sahara ~]$ ls
lecture1
[user@sahara ~]$ 
```
* working directory before was `/home`
* The output of the command was a single directory named `lecture1`, this would make sense as `ls` list files and directories
in the current directory, and only the piece of content in the `/home` directory is lecture1 explaining why it was printed
* The output of the command was not an error

### `ls` with a path to a directory

```shell
[user@sahara ~]$ ls lecture1/
Hello.class  Hello.java  messages  README
[user@sahara ~]$
```
* working directory before was `/home`
* The output above printed the directory content of `/home/lecture1` path. This output contained both files and directories within the lecture1
directory on the file system
* The output was not an error

### `ls` with a path to a file
```shell
[user@sahara ~]$ ls lecture1/messages/de.txt 
lecture1/messages/de.txt
[user@sahara ~]$
```
* working directory before was `/home` 
* The output of the command was identical to the path passed to the command, with no other information printed along with it.
* The output was not an error 
___

## **`cat`**

### `cat` with no arguments 
![Screenshot 2023-10-08 112054](https://github.com/andrewcomputsci2019/cse15l-lab-reports/assets/54915639/3910fcd8-8ac0-4783-a9e4-349e68aedff9)
* Working directory before was `/home`
* Initially the command did nothing but return the cursor to the next line and removed the terminal prompt, but after that cat started to consume lines
typed into the terminal and repeated them back out, until I forced closed cat using `ctrl-c`
* The above output was not an error but may be considered undesirable behavior

### `cat` with a path to a directory
![Screenshot 2023-10-08 111939](https://github.com/andrewcomputsci2019/cse15l-lab-reports/assets/54915639/d3e11f0b-259c-449b-ac00-277f95d8607d)
* Working directory before was `/home` 
* the command output, stated that the passed-in path, `lecture1`, was a directory which is correct as the passed path of `lecture1` is a directory
in the file system
* The above output is an error informing the user that the passed path is not a file, which cat needs in order to print stored
content within a file

### `cat` with a path to a file 
![Screenshot 2023-10-08 112602](https://github.com/andrewcomputsci2019/cse15l-lab-reports/assets/54915639/45935470-18aa-46e6-8c93-2c23c0b6c116)
* Working directory before was /home
* The command displayed the content of the file de.txt by printing it to the console, which makes sense as cat prints a file's content, and the passed path was the path to the `de.txt` file.
* The above output is not an error
