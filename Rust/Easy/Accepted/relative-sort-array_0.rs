impl Solution {
    pub fn relative_sort_array(arr1: Vec<i32>, arr2: Vec<i32>) -> Vec<i32> {
        
        let mut res = Vec::new();
        let mut count = vec![0; 1001];
        for i in arr1 {
            count[i as usize] += 1;
        }
        for i in arr2 {
            while count[i as usize] > 0 {
                res.push(i);
                count[i as usize] -= 1;
            }
        }
        for i in 0..count.len() {
            while count[i] > 0 {
                res.push(i as i32);
                count[i] -= 1;
            }
        }
        res
    }
}