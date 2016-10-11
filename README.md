LDAGibbsSampling
================

/**
Copyright (C) 2013 by
SMU Text Mining Group/Singapore Management University/Peking University

LDAGibbsSampling is distributed for research purpose, but
WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.

Feel free to contact the following people if you find any
problems in the package.
lyang@cs.umass.edu 

Updated in Oct. 10, 2016. * */

Brief Introduction
=============================
1. This is Liu Yang's implementation for Gibbs Sampling of LDA. The data set is Newsgroup-18828, which is included in the project. You can test other data sets with it. Just import the project into Eclipse and run LdaGibbsSampling.java to start it without any configuration. The sample original documents and sample output files have been included. To download the whole Newsgroup-18828 data set, you can refer to http://qwone.com/~jason/20Newsgroups/ . 


2. The format of the output files

   lda_n.params: the hyper-parameters of the LDA model.
   
   lda_n.phi: a K * V matrix, which is the leant topic word distribution.
   
   lda_n.tassign: the topic assignments of each word in each document when there are n iterations.
   
   lda_n.theta: a M * K matrix, which is the learnt document topic distribution.
   
   lda_n.twords: the top topic words with their probabilies under each topic.
   

2. The author's technical blog : http://blog.csdn.net/yangliuy

   The author's homepage:https://people.cs.umass.edu/~lyang

   For more information of LDA and Gibbs Sampling: http://blog.csdn.net/yangliuy/article/details/8302599 (a technical blog on LDA and Gibbs Sampling in Chinese.)

3. This is an initial implementation for the Topic Expertise Model which is proposed in the following paper:

    Liu Yang, Minghui Qiu, Swapna  Gottipati, Feida Zhu, Jing Jiang, Huiping Sun and Zhong Chen. CQARank: Jointly Model Topics and Expertise in Community Question Answering. In Proceedings of the 22nd ACM International Conference on Information and Knowledge Management (CIKM 2013).  (http://dl.acm.org/citation.cfm?id=2505720)

    If you use this model implementation, please cite this paper.

4. We will also release more open source code for topic models in https://github.com/yangliuy.


