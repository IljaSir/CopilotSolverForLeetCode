impl Solution {
    pub fn relative_sort_array(arr1: Vec<i32>, arr2: Vec<i32>) -> Vec<i32> {
        
        let mut arr1 = arr1;
        let mut arr2 = arr2;
        arr2.sort();
        arr1.sort();
        let mut result: Vec<i32> = Vec::new();
        for i in 0..arr2.len() {
            let mut j = 0;
            while j < arr1.len() {
                if arr2[i] == arr1[j] {
                    result.push(arr1.remove(j));
                    j -= 1;
                }
                j += 1;
            }
        }
        result.append(&mut arr1);
        result
    }
}