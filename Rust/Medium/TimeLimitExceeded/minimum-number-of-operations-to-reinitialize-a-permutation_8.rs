impl Solution {
    pub fn reinitialize_permutation(n: i32) -> i32 {
        
        let mut perm = (0..n).collect::<Vec<i32>>();
        let mut arr = perm.clone();
        let mut count = 0;
        loop {
            count += 1;
            for i in 0..n {
                if i % 2 == 0 {
                    arr[i as usize] = perm[(i / 2) as usize];
                } else {
                    arr[i as usize] = perm[(n / 2 + (i - 1) / 2) as usize];
                }
            }
            if arr == perm {
                break;
            }
            perm = arr.clone();
        }
        count
    }
}