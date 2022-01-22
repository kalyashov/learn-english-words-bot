package ru.telegram.learn.english.bot.entity.word;

public enum PartOfSpeech {

    ORDINAL_NUMBER("ordinal number", "numb."),
    NOUN("noun","noun"),
    PREPOSITION("preposition","prep."),
    ADVERB("adverb", "adverb"),
    NUMBER("number", "numb."),
    ADJECTIVE("adjective", "adj."),
    DETERMINER("determiner", "deter."),
    EXCLAMATION("exclamation", "excl."),
    LINKING_VERB("linking verb", "link. verb"),
    VERB("verb", "verb"),
    PRONOUN("pronoun", "pronoun"),
    CONJUNCTION("conjunction", "conj."),
    DEFENITE_ARTICLE("defenite article", "art."),
    MODAL_VERB("modal verb", "mod. verb");

    private final String name;
    private final String shortName;

    PartOfSpeech(String name, String shortName) {
        this.name = name;
        this.shortName = shortName;
    }

    public static String getShortName(String name) {
        for(PartOfSpeech ps: values()) {
            if (ps.name.equals(name))
                return ps.shortName;
        }

        return "";
    }
}
