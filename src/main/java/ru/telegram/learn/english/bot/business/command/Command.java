package ru.telegram.learn.english.bot.business.command;

/**
 * Список команд, которые умеет обрабатывать бот
 */
public enum Command {

    START("/start"),
    STOP("/stop"),
    WORDS("/words"),
    INFO("/info"),
    COMMANDS("/commands"),
    FULL_ACCESS("/full_access"),
    DONATE("/donate"),
    SUPPORT("/support"),
    UNKNOWN("");

    private final String commandRaw;

    Command(String commandRaw) {
        this.commandRaw = commandRaw;
    }

    public static Command fromValue(String commandRaw) {
        for (Command command: values()) {
            if (commandRaw.contains(command.commandRaw)) {
                return command;
            }
        }

        return UNKNOWN;
    }
}
