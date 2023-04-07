package assignments;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

@Getter
@Setter
public class LocalProcessor {
    static ArrayList<String> stringArrayList = new ArrayList<>();
    protected String processorVersion;
    Scanner informationScanner;
    private String processorName;
    private Long period = 1_000_000_000_000_0L;
    private Integer valueOfCheap;

    public LocalProcessor(String processorName, Long period, String ProcessorVersion, Integer valueOfCheap,
                          Scanner informationscanner, ArrayList<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = ProcessorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationscanner;
        this.stringArrayList = stringArrayList;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listIterator(ArrayList<String> stringList) {
        stringArrayList = new ArrayList<>(stringList);
        for (int i = 0; i < period && i < stringArrayList.size(); i++) {
            String str = stringArrayList.get(i);
            if (str != null) {
                System.out.println(str.hashCode());
            }
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
        if (!file.exists()) {
            throw new IllegalStateException("File not found: " + file.getPath());
        }
        informationScanner = new Scanner(file);
        while (informationScanner.hasNext()) {
            processorVersion += informationScanner.nextLine();
        }
    }
}
