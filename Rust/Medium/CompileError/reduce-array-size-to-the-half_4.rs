impl Solution {
    pub fn min_set_size(arr: Vec<i32>) -> i32 {
        
        let mut count = vec![0; 100001];
        for i in arr {
            count[i as usize] += 1;
        }
        count.sort();
        let mut sum = 0;
        let mut res = 0;
        for i in (0..count.len()).rev() {
            sum += count[i];
            res += 1;
            if sum >= arr.len() / 2 {
                break;
            }
        }
        res
    }
}