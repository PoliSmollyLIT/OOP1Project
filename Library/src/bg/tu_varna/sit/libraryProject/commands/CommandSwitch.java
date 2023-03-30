package bg.tu_varna.sit.libraryProject.commands;

public class CommandSwitch {
    public CommandSwitch() {
    }

    public static void runCommand(String enteredCommand) {

        if (enteredCommand.equals(CommandsEnum.OPEN.getCommand())) {
            System.out.println(CommandsEnum.OPEN.getDescription());

        } else if (enteredCommand.equals(CommandsEnum.CLOSE.getCommand())) {
            System.out.println(CommandsEnum.CLOSE.getDescription());

        } else if (enteredCommand.equals(CommandsEnum.SAVE.getCommand())) {
            System.out.println(CommandsEnum.SAVE.getDescription());

        } else if (enteredCommand.equals(CommandsEnum.SAVEAS.getCommand())) {
            System.out.println(CommandsEnum.SAVEAS.getDescription());

        } else if (enteredCommand.equals(CommandsEnum.HELP.getCommand())) {
            for (CommandsEnum command : CommandsEnum.values()) {
                System.out.printf("%-15s %-40s \n", command.getCommand(), command.getDescription());    // %-10s left-aligned space ot 10 pos for text
            }

        } else if (enteredCommand.equals(CommandsEnum.LOGIN.getCommand())) {
            System.out.println(CommandsEnum.LOGIN.getDescription());

        } else if (enteredCommand.equals(CommandsEnum.LOGOUT.getCommand())) {
            System.out.println(CommandsEnum.LOGOUT.getDescription());

        } else if (enteredCommand.equals(CommandsEnum.BOOKS_ALL.getCommand())) {
            System.out.println(CommandsEnum.BOOKS_ALL.getDescription());

        } else if (enteredCommand.equals(CommandsEnum.BOOKS_INFO.getCommand())) {
            System.out.println(CommandsEnum.BOOKS_INFO.getDescription());

        } else if (enteredCommand.equals(CommandsEnum.BOOKS_FIND.getCommand())) {
            System.out.println(CommandsEnum.BOOKS_FIND.getDescription());

        } else if (enteredCommand.equals(CommandsEnum.BOOKS_SORT.getCommand())) {
            System.out.println(CommandsEnum.BOOKS_SORT.getDescription());

        } else if (enteredCommand.equals(CommandsEnum.BOOKS_ADD.getCommand())) {
            System.out.println(CommandsEnum.BOOKS_ADD.getDescription());

        } else if (enteredCommand.equals(CommandsEnum.BOOKS_REMOVE.getCommand())) {
            System.out.println(CommandsEnum.BOOKS_REMOVE.getDescription());

        } else if (enteredCommand.equals(CommandsEnum.USER_ADD.getCommand())) {
            System.out.println(CommandsEnum.USER_ADD.getDescription());

        } else if (enteredCommand.equals(CommandsEnum.USER_REMOVE.getCommand())) {
            System.out.println(CommandsEnum.USER_REMOVE.getDescription());

        } else {
            System.exit(0);
        }

    }
}