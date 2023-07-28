impl Solution {
    pub fn relative_sort_array(arr1: Vec<i32>, arr2: Vec<i32>) -> Vec<i32> {
        
        let mut arr1 = arr1;
        let mut arr2 = arr2;
        arr2.sort();
        arr1.sort();
        let mut res: Vec<i32> = Vec::new();
        for i in arr2.iter() {
            while let Some(index) = arr1.iter().position(|&x| x == *i) {
                res.push(arr1.remove(index));
            }
        }
        for i in arr1.iter() {
            res.push(*i);
        }
        res
    }
}