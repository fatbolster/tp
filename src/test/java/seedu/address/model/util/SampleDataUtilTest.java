package seedu.address.model.util;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.util.Set;
import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.Person;
import seedu.address.model.tag.Tag;

public class SampleDataUtilTest {
    @Test
    void getSamplePersons_containAllowedTags() {
        Person[] addressBookIndividuals = SampleDataUtil.getSamplePersons();
        Set<String> allowedTags = Set.of("low", "medium", "high");

        for (Person p: addressBookIndividuals) {
            for (Tag t: p.getTags()) {
                assertTrue(allowedTags.contains(t.tagName.toLowerCase()));
            }
        }
    }

    @Test
    void getSampleAddressBook_containsSamplePersons() {
        Person[] addressBookIndividuals = SampleDataUtil.getSamplePersons();
        ReadOnlyAddressBook ab = SampleDataUtil.getSampleAddressBook();
        AddressBook abForComparison = (AddressBook) ab;
        for (Person p: addressBookIndividuals) {
            assertTrue(abForComparison.hasPerson(p));
        }

    }
}
