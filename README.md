# happyNumbers
This is just a silly project driven by "can I do it?" thought

Some time ago on JoeMonster I read about happy numbers https://en.wikipedia.org/wiki/Happy_number 
It's a perfect exercise after working with Spring, something light, no pressure.

### Tactic Plan
~~1. method that checks if given number is Happy
1.1 tdd~~
~~1.2 working method ignoring Big-O~~
~~2. terminal interface~~
~~3. optimising method for better Big-O (non-adequate)~~
~~4. finding the closest Happy Number to number given by user~~
~~5. finding all happy Numbers in range given by user~~
~~6. method for finding happy Prime Numbers for all options~~ 
?. numbers n-happy (happy but when raised not to 2nd but n-th power)

I'm going to try TDD; I never really kept that principle, time was always short :( (so my skill) [it was not that hard and save me some time, when it was to decide what should be return type for the method]

Second thing to do is optimisation for better big-O notation result

##I consider it closed. 
All tests are green, 
aside for terminal UI, I managed to create methods for:

`finding happy number`

`finding the closest happy number to given by user`

`finding all happy numbers in range given by user (minding that there would be two such numbers)`

`and corresponding methods for number which are both happy and prime`

I may return to this project for making GUI, n-happy numbers are not so tempting; ist more of a writing than problem solving