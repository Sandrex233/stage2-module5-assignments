package assignments;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

@Getter
@Setter
public class LocalProcessor {
    static LinkedList<String> stringArrayList = new LinkedList<>();
    protected String ProcessorVersion;
    Scanner informationScanner;
    private String processorName;
    private Long period = 1_000_000_000_000_0L;
    private Integer valueOfCheap;

    public LocalProcessor(String processorName, Long period, String processorVersion, Integer valueOfCheap,
                          Scanner informationscanner, LinkedList<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        ProcessorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationscanner;
        this.stringArrayList = stringArrayList;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listIterator(LinkedList<String> stringList) {
        stringArrayList = new LinkedList<>(stringList);
        for (int i = 0; i < period && i < stringArrayList.size(); i++) {
            System.out.println(stringArrayList.get(i).hashCode());
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(LinkedList<String> stringList) {
        StringBuilder fullNameBuilder = new StringBuilder(processorName);
        for (String str : stringList) {
            fullNameBuilder.append(' ').append(str);
        }
        return fullNameBuilder.toString();
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) throws FileNotFoundException {
        informationScanner = new Scanner(file);
        while (informationScanner.hasNext()) {
            ProcessorVersion += informationScanner.nextLine();
        }

    }
}
