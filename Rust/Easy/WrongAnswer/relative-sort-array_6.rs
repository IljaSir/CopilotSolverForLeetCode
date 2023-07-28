impl Solution {
    pub fn relative_sort_array(arr1: Vec<i32>, arr2: Vec<i32>) -> Vec<i32> {
        
        let mut arr1 = arr1;
        let mut arr2 = arr2;
        arr2.sort_unstable();
        arr1.sort_unstable();
        let mut res = vec![];
        let mut i = 0;
        for x in arr2 {
            while i < arr1.len() && arr1[i] < x {
                res.push(arr1[i]);
                i += 1;
            }
            while i < arr1.len() && arr1[i] == x {
                res.push(arr1[i]);
                i += 1;
            }
        }
        while i < arr1.len() {
            res.push(arr1[i]);
            i += 1;
        }
        res
    }
}