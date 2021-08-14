--liquibase formatted sql
--changeset kalyashov-ga:insert_words rollbackSplitStatements:true
--comment: Наполнение таблицы английскими словами
INSERT INTO ENGLISH_WORDS(ID, WORD, TRANSLATION, PART_OF_SPEECH, LEVEL, EMOJI, AUDIO_LINK, CREATED_AT, UPDATED_AT)
VALUES
(1, 'a',            'один, одна, одно', 'indefinite article',   'a1', '🙅‍♂️',  'https://www.oxfordlearnersdictionaries.com/media/english/uk_pron/a/a__/a__gb/a__gb_2.mp3', now(), now()),
(2, 'abandon',      'покидать',         'verb',                 'b2', '🙅‍♂️',   'https://www.oxfordlearnersdictionaries.com/media/english/uk_pron/a/aba/aband/abandon__gb_2.mp3', now(), now()),
(3,	'ability',	    'способность',      'noun',                 'a2', '🙅‍♂️',   'https://www.oxfordlearnersdictionaries.com/media/english/uk_pron/a/abi/abili/ability__gb_1.mp3', now(), now()),
(4,	'able',	        'способный',	    'adjective',            'a2', '🙅‍♂️',   'https://www.oxfordlearnersdictionaries.com/media/english/uk_pron/a/abl/able_/able__gb_1.mp3', now(), now()),
(5,	'abolish',	    'отменять',	        'verb',                 'c1', '🙅‍♂️',	'https://www.oxfordlearnersdictionaries.com/media/english/uk_pron/a/abo/aboli/abolish__gb_2.mp3', now(), now()),
(6,	'abortion',	    'аборт',	        'noun',                 'c1', '🙅‍♂️',	'https://www.oxfordlearnersdictionaries.com/media/english/uk_pron/a/abo/abort/abortion__gb_1.mp3', now(), now()),
(7,	'about',	    'почти, примерно',	'adverb',	            'a1', '🙅‍♂️',	'https://www.oxfordlearnersdictionaries.com/media/english/uk_pron/a/abo/about/about__gb_1.mp3', now(), now()),
(8,	'about',	    'о',	            'preposition',          'a1', '🙅‍♂️',	'https://www.oxfordlearnersdictionaries.com/media/english/uk_pron/a/abo/about/about__gb_1.mp3', now(), now()),
(9,	'above',	    'выше',	            'adverb',	            'a1', '🙅‍♂️',	'https://www.oxfordlearnersdictionaries.com/media/english/uk_pron/a/abo/above/above__gb_1.mp3', now(), now()),
(10, 'above',	    'выше',	            'preposition',	        'a1', '🙅‍♂️',	'https://www.oxfordlearnersdictionaries.com/media/english/uk_pron/a/abo/above/above__gb_1.mp3', now(), now()),
(11, 'abroad',	    'за границей',	    'adverb',	            'a2', '🙅‍♂️',   'https://www.oxfordlearnersdictionaries.com/media/english/uk_pron/a/abr/abroa/abroad__gb_2.mp3', now(), now()),
(12, 'absence',	    'отсутствие',	    'noun',	                'c1', '🙅‍♂️',	'https://www.oxfordlearnersdictionaries.com/media/english/uk_pron/a/abs/absen/absence__gb_1.mp3', now(), now()),
(13, 'absent',	    'нет на месте',	    'adjective',	        'c1', '🙅‍♂️',	'https://www.oxfordlearnersdictionaries.com/media/english/uk_pron/a/abs/absen/absent__gb_4.mp3', now(), now()),
(14, 'absolute',	'абсолютный',	    'adjective',	        'b2', '🙅‍♂️',	'https://www.oxfordlearnersdictionaries.com/media/english/uk_pron/a/abs/absol/absolute__gb_1.mp3', now(), now()),
(15, 'absolutely',	'абсолютно',	    'adverb',	            'b1', '🙅‍♂️',	'https://www.oxfordlearnersdictionaries.com/media/english/uk_pron/a/abs/absol/absolutely__gb_6.mp3', now(), now()),
(16, 'absorb',	    'поглощать',	    'verb',	                'b2', '🙅‍♂️',	'https://www.oxfordlearnersdictionaries.com/media/english/uk_pron/a/abs/absor/absorb__gb_2.mp3', now(), now()),
(17, 'abstract',	'абстрактный',	    'adjective',	        'b2', '🙅‍♂️',	'https://www.oxfordlearnersdictionaries.com/media/english/uk_pron/a/abs/abstr/abstract__gb_5.mp3', now(), now()),
(18, 'absurd',	    'абсурдный',	    'adjective',	        'c1', '🙅‍♂️',	'https://www.oxfordlearnersdictionaries.com/media/english/uk_pron/a/abs/absur/absurd__gb_1.mp3', now(), now()),
(19, 'abundance',	'избыток',	        'noun',	                'c1', '🙅‍♂️',	'https://www.oxfordlearnersdictionaries.com/media/english/uk_pron/a/abu/abund/abundance__gb_1.mp3', now(), now()),
(20, 'abuse',		'злоупотреблять',	'noun',                 'c1', '🙅‍♂️',	'https://www.oxfordlearnersdictionaries.com/media/english/uk_pron/a/abu/abuse/abuse__gb_1.mp3', now(), now());
