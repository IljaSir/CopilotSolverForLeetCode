impl Solution {
    pub fn can_arrange(arr: Vec<i32>, k: i32) -> bool {
        
        let mut cnt = vec![0; k as usize];
        for &x in arr.iter() {
            cnt[((x % k) + k) as usize % k as usize] += 1;
        }
        for i in 1..k as usize / 2 + 1 {
            if cnt[i] != cnt[k as usize - i] {
                return false;
            }
        }
        cnt[0] % 2 == 0
    }
}