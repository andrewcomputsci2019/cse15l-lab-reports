# Lab Report 1 - Remote Acess and FileSystem
___
## **command CD**

### CD no arguments
```shell
[user@sahara ~]$ pwd
/home
[user@sahara ~]$ cd
[user@sahara ~]$
```
* working directory before was `/home`
* No notice differnce occured aftering running the command, no directory changed occured as no directory was passed to the cd command
* The output was not a error 

### CD with path to directory

```shell
[user@sahara ~]$ pwd
/home
[user@sahara ~]$ cd lecture1/
[user@sahara ~/lecture1]$ pwd
/home/lecture1
[user@sahara ~/lecture1]$
```
* working directory before was `/home`
* The location before the `$` signed changed from `~` to `~/lecture1`, this shows that terminal is now in the lecture1 directory
in the user home directory 
* the output is not an error 

### CD with path to a File 

```shell
[user@sahara ~/lecture1]$ pwd
/home/lecture1
[user@sahara ~/lecture1]$ cd messages/de.txt 
bash: cd: messages/de.txt: Not a directory
[user@sahara ~/lecture1]$ 
```
* working directory before was` /home/lecture1`
* The output of the command was an error  message reporting that cd was unable to open  
* The output was an error, as cd is unable to change to a dictory that is not a directory such as a file 
___

## **ls**

### ls with no arguments

```shell
[user@sahara ~]$ pwd
/home
[user@sahara ~]$ ls
lecture1
[user@sahara ~]$ 
```
* working directory before was /home 
* The output of the command was a single directory named lecture1, this would make sense as ls list files and directories
in the current directory and only the piece of content in the `/home` directory is lecture1 expaling why it was printed
* The output of the command was not an error

### ls with directory path

```shell
[user@sahara ~]$ ls lecture1/
Hello.class  Hello.java  messages  README
[user@sahara ~]$
```
* working directory before was `/home`
* The output above printed the directory content of `/home/lecture1` path. This output contained both files and directories within the lecture1
directories 
* The out put was not an error

### ls with file path
```shell
[user@sahara ~]$ ls lecture1/messages/de.txt 
lecture1/messages/de.txt
[user@sahara ~]$
```
* working directory before was `/home` 
* The output was identical to the path passed to the ls command with no other information with it.
* The output was not an error 
___

## **cat**

### cat with no arguments 


* Working directory before was `/home`
* Initialy the command did nothing but return the carret to the next line and removed the terminal prompt, but after that cat started to consume lines
typed in and reapted them back out, until I fored closed cat using `ctrl-c`
* The above output was not an error, but maybe consider undiserable beahvior

### cat with path to directory

* Working directory before was `/home` 
* the command outputed that the passed in path was a directory wich is correct as the passed path of lecture1 is a directory
in the file system
* The above output is an error informing the user that the passed path is not a file, which cat needs inorder to print stored
cotent within a file

### cat with path to file 

* Working directory before was /home
* The command displayed the file's content by printing it to the console
* the above output is not an error
___
