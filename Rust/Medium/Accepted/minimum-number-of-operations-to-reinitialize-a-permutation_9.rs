impl Solution {
    pub fn reinitialize_permutation(n: i32) -> i32 {
        
        let n = n as usize;
        let mut arr = vec![0; n];
        for i in 0..n {
            arr[i] = i;
        }
        let mut count = 0;
        let mut perm = arr.clone();
        loop {
            count += 1;
            for i in 0..n {
                if i % 2 == 0 {
                    perm[i] = arr[i / 2];
                } else {
                    perm[i] = arr[n / 2 + (i - 1) / 2];
                }
            }
            arr = perm.clone();
            if arr == (0..n).collect::<Vec<usize>>() {
                break;
            }
        }
        count
    }
}