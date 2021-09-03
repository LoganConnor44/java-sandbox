package loganconnor44.katas;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UniqueEmail {

    public int numberOfUniqueEmails(String[] emails) {
        return this.cleanEmails(emails)
            .values()
            .stream()
            .mapToInt(Set::size)
            .sum();
    }

    private Map<String, Set<String>> cleanEmails(String[] emails) {
        Map<String, Set<String>> uniqueEmails = new HashMap<>();
        for (String email : emails) {
            int atSignIndex = email.indexOf("@");
            String domain = email.substring(atSignIndex);
            String localName = email.substring(0, atSignIndex);
            if (localName.indexOf("+") > -1) {
                localName = localName.substring(0, localName.indexOf("+"));
            }
            if (localName.indexOf(".") > -1) {
                localName = localName.replace(".", "");
            }

            if (uniqueEmails.containsKey(domain)) {
                uniqueEmails.get(domain).add(localName);
            } else {
                uniqueEmails.put(domain, Stream.of(localName).collect(Collectors.toCollection(HashSet::new)));
            }
            

        }
        return uniqueEmails;
    }
    
}
