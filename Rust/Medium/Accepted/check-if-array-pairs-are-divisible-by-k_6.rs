impl Solution {
    pub fn can_arrange(arr: Vec<i32>, k: i32) -> bool {
        
        let mut m = vec![0; k as usize];
        for a in arr {
            let a = (a % k + k) % k;
            m[a as usize] += 1;
        }
        for i in 1..k as usize / 2 + 1 {
            if m[i] != m[k as usize - i] {
                return false;
            }
        }
        m[0] % 2 == 0
    }
}