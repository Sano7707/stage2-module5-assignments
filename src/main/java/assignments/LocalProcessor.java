package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private StringBuilder processorName;
    private long period = 10_000_000_000_000L;
    private StringBuilder processorVersion;
    private int valueOfCheap;
    private Scanner informationScanner;
    private List<String> stringArrayList = new LinkedList<>();


    public LocalProcessor(StringBuilder processorName, long period, StringBuilder processorVersion, int valueOfCheap,
                          Scanner informationScanner, List<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        this.stringArrayList = stringArrayList;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listIterator(List<String> stringList) {
        stringArrayList = new LinkedList<>(stringList);
        for (String s : stringArrayList) {
            try {
                System.out.println(s.hashCode());
            }
            catch (Exception exception){
                exception.printStackTrace();
            }
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public StringBuilder fullNameProcessorGenerator(List<String> stringList) {
        for (int i = 0; i < stringArrayList.size(); i++) {
            processorName.append(stringList.get(i)).append(' ');
        }
        return processorName;
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file){
        try {
            informationScanner = new Scanner(file);
            while (informationScanner.hasNext()) {
                processorVersion.append(informationScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        finally {
            informationScanner.close();
        }
    }

}
