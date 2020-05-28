import ru.tarasovproject.webapp.model.Resume;
import ru.tarasovproject.webapp.storage.AbstractArrayStorage;
import ru.tarasovproject.webapp.storage.ArrayStorage;
import ru.tarasovproject.webapp.storage.SortedArrayStorage;

/**
 * Test for your ArrayStorage implementation
 */
public class MainTestArrayStorage {
    static final AbstractArrayStorage ARRAY_STORAGE = new ArrayStorage();
    static final AbstractArrayStorage SORTED_ARRAY_STORAGE = new SortedArrayStorage();

    public static void main(String[] args) {
        Resume r1 = new Resume("uuid1");
        Resume r2 = new Resume("uuid2");
        Resume r3 = new Resume("uuid3");
        Resume r5 = new Resume("uuid4");
        Resume r6 = new Resume("uuid5");
        Resume r7 = new Resume("uuid6");
        Resume r8 = new Resume("tar");
        Resume resume = new Resume("lalala");


        SORTED_ARRAY_STORAGE.save(r3);
        SORTED_ARRAY_STORAGE.save(r1);
        SORTED_ARRAY_STORAGE.save(r5);
        SORTED_ARRAY_STORAGE.save(r2);
        SORTED_ARRAY_STORAGE.save(r7);
        SORTED_ARRAY_STORAGE.save(r6);
        SORTED_ARRAY_STORAGE.delete("uuid3");
        System.out.println(SORTED_ARRAY_STORAGE.get("uuid2"));
        SORTED_ARRAY_STORAGE.update(r8);

        System.out.println(SORTED_ARRAY_STORAGE.getAll());



        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(resume);
        ARRAY_STORAGE.save(r3);
        ARRAY_STORAGE.save(r5);
        ARRAY_STORAGE.save(r6);
        ARRAY_STORAGE.save(r7);
        //ARRAY_STORAGE.clear();
        ARRAY_STORAGE.update(resume);

        ARRAY_STORAGE.delete("uuid5");
        ARRAY_STORAGE.save(r8);
        printAll();

        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Get r1: " + SORTED_ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        printAll();
        ARRAY_STORAGE.delete(r1.getUuid());
        printAll();
        ARRAY_STORAGE.clear();
        printAll();


        System.out.println("Size: " + ARRAY_STORAGE.size());

    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAll()) {
            System.out.println(r);
        }
    }
}
