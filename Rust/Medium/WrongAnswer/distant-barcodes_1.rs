impl Solution {
    pub fn rearrange_barcodes(barcodes: Vec<i32>) -> Vec<i32> {
        
        let mut barcodes = barcodes;
        let n = barcodes.len();
        barcodes.sort();
        let mut res = vec![0; n];
        let mut i = 0;
        let mut j = 1;
        let mut k = 0;
        while i < n {
            res[k] = barcodes[i];
            i += 1;
            k += 2;
            if k >= n {
                k = j;
                j += 1;
            }
        }
        res
    }
}