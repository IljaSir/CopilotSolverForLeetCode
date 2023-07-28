impl Solution {
    pub fn relative_sort_array(arr1: Vec<i32>, arr2: Vec<i32>) -> Vec<i32> {
        
        let mut arr1 = arr1;
        let mut arr2 = arr2;
        arr1.sort();
        arr2.sort();
        let mut arr3 = Vec::new();
        let mut arr4 = Vec::new();
        for i in &arr2 {
            let mut j = 0;
            while j < arr1.len() {
                if arr1[j] == *i {
                    arr3.push(arr1[j]);
                    arr1.remove(j);
                } else {
                    j += 1;
                }
            }
        }
        arr4.append(&mut arr3);
        arr4.append(&mut arr1);
        arr4
    }
}