impl Solution {
    pub fn count_points(rings: String) -> i32 {
        
        let mut res = 0;
        let mut c = [0; 3];
        for i in 0..10 {
            let mut j = 0;
            while j < rings.len() {
                if rings[j] == '0' + i as u8 {
                    let k = match rings[j-1] {
                        'R' => 0,
                        'G' => 1,
                        'B' => 2,
                        _ => panic!(),
                    };
                    c[k] += 1;
                }
                j += 2;
            }
            if c.iter().all(|x| *x > 0) {
                res += 1;
            }
            c = [0; 3];
        }
        res
    }
}