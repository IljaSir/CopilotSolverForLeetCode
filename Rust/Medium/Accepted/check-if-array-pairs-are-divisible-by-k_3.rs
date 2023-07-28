impl Solution {
    pub fn can_arrange(arr: Vec<i32>, k: i32) -> bool {
        
        let mut count = vec![0; k as usize];
        for a in arr {
            count[((a % k + k) % k) as usize] += 1;
        }
        for i in 1..k as usize / 2 + 1 {
            if count[i] != count[k as usize - i] {
                return false;
            }
        }
        count[0] % 2 == 0
    }
}