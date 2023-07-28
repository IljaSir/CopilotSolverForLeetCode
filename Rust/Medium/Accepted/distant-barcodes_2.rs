impl Solution {
    pub fn rearrange_barcodes(barcodes: Vec<i32>) -> Vec<i32> {
        
        let mut counter: Vec<i32> = vec![0; 10001];
        let mut max = 0;
        let mut max_idx = 0;
        for &n in barcodes.iter() {
            counter[n as usize] += 1;
            if counter[n as usize] > max {
                max = counter[n as usize];
                max_idx = n as usize;
            }
        }
        let mut res = vec![0; barcodes.len()];
        let mut idx = 0;
        for i in 0..max {
            res[idx] = max_idx as i32;
            idx += 2;
        }
        counter[max_idx] = 0;
        for i in 0..10001 {
            while counter[i] > 0 {
                if idx >= barcodes.len() {
                    idx = 1;
                }
                res[idx] = i as i32;
                idx += 2;
                counter[i] -= 1;
            }
        }
        res
    }
}