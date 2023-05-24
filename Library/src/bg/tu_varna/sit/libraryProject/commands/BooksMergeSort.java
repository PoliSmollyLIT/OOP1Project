package bg.tu_varna.sit.libraryProject.commands;

import java.util.ArrayList;

import bg.tu_varna.sit.libraryProject.books.Book;
import bg.tu_varna.sit.libraryProject.books.BookListSingleton;

public class BooksMergeSort {
    private ArrayList<Book> inputArray;
    
    public BooksMergeSort(){
        this.inputArray = BookListSingleton.getInstance().getAllBooks();
    }
    
    public void sortGivenArray( String criteria, boolean asc){       
        divide(0, this.inputArray.size()-1, criteria, asc);
    }
    
    public void divide(int startIndex,int endIndex, String criteria, boolean asc){        
        //Divide till you breakdown your list to single element
        if(startIndex<endIndex && (endIndex-startIndex)>=1){
            int mid = (endIndex + startIndex)/2;
            divide(startIndex, mid, criteria, asc);
            divide(mid+1, endIndex, criteria, asc);        
            
            //merging Sorted array produce above into one sorted array
            merger(startIndex,mid,endIndex, criteria, asc);            
        }       
    }   
    
    public void mergerTitleAsc(ArrayList<Book> mergedSortedArray, int leftIndex,int rightIndex, int midIndex, int endIndex){
        while(leftIndex<=midIndex && rightIndex<=endIndex){
                if(inputArray.get(leftIndex).getTitle().compareTo(inputArray.get(rightIndex).getTitle())<=0){
                    mergedSortedArray.add(inputArray.get(leftIndex));
                    leftIndex++;
                }else{
                    mergedSortedArray.add(inputArray.get(rightIndex));
                    rightIndex++;
                }
            }
    }
    public void mergerTitleDesc(ArrayList<Book> mergedSortedArray, int leftIndex, int rightIndex, int midIndex, int endIndex){
        while(leftIndex<=midIndex && rightIndex<=endIndex){
            if(inputArray.get(leftIndex).getTitle().compareTo(inputArray.get(rightIndex).getTitle())>0){
                    mergedSortedArray.add(inputArray.get(leftIndex));
                    leftIndex++;
                }else{
                    mergedSortedArray.add(inputArray.get(rightIndex));
                    rightIndex++;
                }
        }
    }

    public void mergerAuthorAsc(ArrayList<Book> mergedSortedArray, int leftIndex, int rightIndex, int midIndex, int endIndex){
        while(leftIndex<=midIndex && rightIndex<=endIndex){
            if(inputArray.get(leftIndex).getAuthor().compareTo(inputArray.get(rightIndex).getAuthor())>0){
                    mergedSortedArray.add(inputArray.get(leftIndex));
                    leftIndex++;
                }else{
                    mergedSortedArray.add(inputArray.get(rightIndex));
                    rightIndex++;
                }
        }
    }

    public void mergerAuthorDesc(ArrayList<Book> mergedSortedArray, int leftIndex, int rightIndex, int midIndex, int endIndex){
        while(leftIndex<=midIndex && rightIndex<=endIndex){
            if(inputArray.get(leftIndex).getAuthor().compareTo(inputArray.get(rightIndex).getAuthor())<0){
                    mergedSortedArray.add(inputArray.get(leftIndex));
                    leftIndex++;
                }else{
                    mergedSortedArray.add(inputArray.get(rightIndex));
                    rightIndex++;
                }
        }
    }

    public void mergerYearAsc(ArrayList<Book> mergedSortedArray, int leftIndex, int rightIndex, int midIndex, int endIndex){
        while(leftIndex<=midIndex && rightIndex<=endIndex){
            if(inputArray.get(leftIndex).getPublishingYear() < inputArray.get(rightIndex).getPublishingYear()){
                    mergedSortedArray.add(inputArray.get(leftIndex));
                    leftIndex++;
                }else{
                    mergedSortedArray.add(inputArray.get(rightIndex));
                    rightIndex++;
                }
        }
    }

    public void mergerYearDesc(ArrayList<Book> mergedSortedArray, int leftIndex, int rightIndex, int midIndex, int endIndex){
        while(leftIndex<=midIndex && rightIndex<=endIndex){
            if(inputArray.get(leftIndex).getPublishingYear() >= inputArray.get(rightIndex).getPublishingYear()){
                    mergedSortedArray.add(inputArray.get(leftIndex));
                    leftIndex++;
                }else{
                    mergedSortedArray.add(inputArray.get(rightIndex));
                    rightIndex++;
                }
        }
    }

    public void mergerRaitingAsc(ArrayList<Book> mergedSortedArray, int leftIndex, int rightIndex, int midIndex, int endIndex){
        while(leftIndex<=midIndex && rightIndex<=endIndex){
            if(inputArray.get(leftIndex).getRaiting().getRaiting().compareTo(inputArray.get(rightIndex).getRaiting().getRaiting())<0){
                    mergedSortedArray.add(inputArray.get(leftIndex));
                    leftIndex++;
                }else{
                    mergedSortedArray.add(inputArray.get(rightIndex));
                    rightIndex++;
                }
        }
    }

    
    public void mergerRaitingDesc(ArrayList<Book> mergedSortedArray, int leftIndex, int rightIndex, int midIndex, int endIndex){
        while(leftIndex<=midIndex && rightIndex<=endIndex){
            if(inputArray.get(leftIndex).getRaiting().getRaiting().compareTo(inputArray.get(rightIndex).getRaiting().getRaiting())>0){
                    mergedSortedArray.add(inputArray.get(leftIndex));
                    leftIndex++;
                }else{
                    mergedSortedArray.add(inputArray.get(rightIndex));
                    rightIndex++;
                }
        }
    }

    public void merger(int startIndex,int midIndex,int endIndex,  String criteria, boolean asc){
        ArrayList<Book> mergedSortedArray = new ArrayList<Book>();
        
        int leftIndex = startIndex;
        int rightIndex = midIndex+1;
        
        if(criteria == "title"){
            if(asc == true){
                mergerTitleAsc(mergedSortedArray, leftIndex, rightIndex, midIndex, endIndex);
            }else{
                mergerTitleDesc(mergedSortedArray, leftIndex, rightIndex, midIndex, endIndex);
            }
        }else if( criteria == "author"){
            if(asc == true){
                mergerTitleAsc(mergedSortedArray, leftIndex, rightIndex, midIndex, endIndex);
            }else{
                mergerTitleDesc(mergedSortedArray, leftIndex, rightIndex, midIndex, endIndex);
            }
        }else if(criteria == "year"){
            if(asc == true){
                mergerYearAsc(mergedSortedArray, leftIndex, rightIndex, midIndex, endIndex);
            }else{
                mergerYearDesc(mergedSortedArray, leftIndex, rightIndex, midIndex, endIndex);
            }
        }else if(criteria == "raiting"){
            if(asc ==  true){
                mergerRaitingAsc(mergedSortedArray, leftIndex, rightIndex, midIndex, endIndex);
            }else{
                mergerRaitingDesc(mergedSortedArray, leftIndex, rightIndex, midIndex, endIndex);
            }
        }
        
        //Either of below while loop will execute
        while(leftIndex<=midIndex){
            mergedSortedArray.add(inputArray.get(leftIndex));
            leftIndex++;
        }
        
        while(rightIndex<=endIndex){
            mergedSortedArray.add(inputArray.get(rightIndex));
            rightIndex++;
        }
        
        int i = 0;
        int j = startIndex;
        //Setting sorted array to original one
        while(i<mergedSortedArray.size()){
            inputArray.set(j, mergedSortedArray.get(i++));
            j++;
        }
    
    }
}