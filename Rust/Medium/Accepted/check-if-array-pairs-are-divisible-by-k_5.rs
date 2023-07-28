impl Solution {
    pub fn can_arrange(arr: Vec<i32>, k: i32) -> bool {
        
        let mut m = vec![0; k as usize];
        for &n in arr.iter() {
            m[((n % k) + k) as usize % k as usize] += 1;
        }
        if m[0] % 2 != 0 {
            return false;
        }
        for i in 1..k/2+1 {
            if m[i as usize] != m[(k-i) as usize] {
                return false;
            }
        }
        true
    }
}