impl Solution {
    pub fn relative_sort_array(arr1: Vec<i32>, arr2: Vec<i32>) -> Vec<i32> {
        
        let mut arr1 = arr1;
        let mut arr2 = arr2;
        let mut arr3 = Vec::new();
        let mut arr4 = Vec::new();
        arr2.sort();
        for i in arr1.iter() {
            if arr2.contains(i) {
                arr3.push(*i);
            } else {
                arr4.push(*i);
            }
        }
        arr4.sort();
        arr3.append(&mut arr4);
        arr3
    }
}