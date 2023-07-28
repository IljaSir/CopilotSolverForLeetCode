impl Solution {
    pub fn can_arrange(arr: Vec<i32>, k: i32) -> bool {
        
        if arr.len() % 2 != 0 {
            return false;
        }
        let mut pairs = vec![0; k as usize];
        for i in 0..arr.len() {
            let r = arr[i] % k;
            pairs[(r + k) as usize % k as usize] += 1;
        }
        for i in 1..k as usize / 2 + 1 {
            if pairs[i] != pairs[k as usize - i] {
                return false;
            }
        }
        if k % 2 == 0 && pairs[k as usize / 2] % 2 != 0 {
            return false;
        }
        true
    }
}