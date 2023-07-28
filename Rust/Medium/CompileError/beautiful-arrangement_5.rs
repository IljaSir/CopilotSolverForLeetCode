impl Solution {
    pub fn count_arrangement(n: i32) -> i32 {
        

        let mut arr = vec![0; n as usize];
        for i in 0..n as usize {
            arr[i] = i + 1;
        }
        let mut res = 0;
        Solution::helper(&mut arr, 0, &mut res);
        res
    }
    
    fn helper(arr: &mut Vec<i32>, i: usize, res: &mut i32) {
        if i == arr.len() {
            *res += 1;
            return;
        }
        for j in i..arr.len() {
            if arr[j] % (i + 1) == 0 || (i + 1) % arr[j] == 0 {
                arr.swap(i, j);
                Solution::helper(arr, i + 1, res);
                arr.swap(i, j);
            }
        }