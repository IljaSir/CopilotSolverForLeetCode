impl Solution {
    pub fn min_swaps_couples(row: Vec<i32>) -> i32 {
        
        let mut r = row;
        let mut c = 0;
        for i in 0..r.len()/2 {
            if r[2*i+1]-r[2*i] != 1 {
                c += 1;
                for j in 2*i+2..r.len() {
                    if r[j] == r[2*i]+1 {
                        r.swap(j, 2*i+1);
                        break;
                    }
                }
            }
        }
        c
    }
}