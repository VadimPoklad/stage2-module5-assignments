package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.logging.Logger;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private StringBuilder processorName;
    private Long period;
    private StringBuilder processorVersion;
    private Integer valueOfCheap;
    private Scanner informationScanner;
    private List<String> stringList;
    private final Logger logger = Logger.getLogger(LocalProcessor.class.getName());

    public LocalProcessor(StringBuilder processorName,
                          Long period,
                          StringBuilder processorVersion,
                          Integer valueOfCheap,
                          Scanner informationScanner,
                          List<String> stringList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        this.stringList = stringList;
    }

    public LocalProcessor() {
    }
    @ListIteratorAnnotation
    public void listIterator(List<String> stringList) throws IllegalStateException{
        try {
            if(Objects.isNull(stringList)){throw new IllegalStateException("List is null");}
            stringList.forEach(o->System.out.println(Objects.nonNull(o) ? o.hashCode(): ""));
        }catch (IllegalStateException exception){
            logger.info(exception.getMessage());
            throw new IllegalStateException(exception);
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String generateFullProcessorName(List<String> stringList) throws IllegalStateException{
        try {
            if(Objects.isNull(stringList)){throw new IllegalStateException("List is null");}
            stringList.forEach(o->processorName.append(o).append(" "));
            return processorName.toString();
        }catch (IllegalStateException exception){
            logger.info(exception.getMessage());
            throw new IllegalStateException(exception);
        }
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) throws IllegalStateException {
        try {
            informationScanner = new Scanner(file);
            if (Objects.isNull(informationScanner)) {
                throw new IllegalStateException("File is null");
            }
            while (informationScanner.hasNext()) {
                processorVersion.append(informationScanner.nextLine());
            }
        } catch (FileNotFoundException exception) {
            logger.info(exception.getMessage());
            throw new IllegalStateException(exception);
        } finally {
            if (informationScanner != null) {
                informationScanner.close();
            }
        }
    }
}
