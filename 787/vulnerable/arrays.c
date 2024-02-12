// Online C compiler to run C program online
#include <stdio.h>

int main() {
    // Write C code here
    int id_sequence[3];
    
    printf("Initially, the size of array is %d bytes\n", sizeof(id_sequence));

    /* Populate the id array. */
    id_sequence[0] = 123;
    id_sequence[1] = 234;
    id_sequence[2] = 345;
    id_sequence[3] = 456;
    
    printf("Added another value at 4th index: %d\n", id_sequence[3]);
    
    printf("The size of array now is %d bytes", sizeof(id_sequence));

    return 0;
}

// OUTPUT
// Initially, the size of array is 12 bytes
// Added another value at 4th index: 456
// The size of array now is 12 bytes

// Notice that the size of the array is not increased by 4 bytes as it's Out-Of-Bounds write and is prone to
// data loss