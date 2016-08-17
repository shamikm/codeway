How to design a system that takes big URLs like
“http://www.geeksforgeeks.org/count-sum-of-digits-in-numbers-from-1-to-n/”
and converts them into a short 6 character URL.

Solution
----------

It is given that URLs are stored in database and every URL has an
associated integer id.One important thing to note is, the long url should
also be uniquely identifiable from short url. So we need a Bijective Function.