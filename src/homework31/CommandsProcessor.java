package homework31;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Scanner;

@Service
public class CommandsProcessor {

    @Resource
    private Map<String, TerminalCommand> commandMap;

    public void executeCommand(String commandName) {
        TerminalCommand command = commandMap.get(commandName);
        if (command != null) {
            command.run();
        } else {
            System.out.println("Command not found: " + commandName);
        }
    }

    public void run() {
        String command = "";
        Scanner s = new Scanner(System.in);

        while (!"exit".equals(command)) {
            System.out.println("input command:");

            command = s.nextLine();

            if (!"exit".equals(command))
                this.executeCommand(command);
        }

    }
}