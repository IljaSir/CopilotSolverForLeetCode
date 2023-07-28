impl Solution {
    pub fn avoid_flood(rains: Vec<i32>) -> Vec<i32> {
        
        let mut lake: Vec<i32> = vec![-1; 100000];
        let mut res: Vec<i32> = vec![];
        let mut dry: Vec<i32> = vec![];
        for (i, &r) in rains.iter().enumerate() {
            if r == 0 {
                res.push(1);
                dry.push(i as i32);
            } else {
                if lake[r as usize - 1] != -1 {
                    let mut flag = false;
                    for j in 0..dry.len() {
                        if dry[j] > lake[r as usize - 1] {
                            res[dry[j] as usize] = r;
                            dry.remove(j);
                            lake[r as usize - 1] = i as i32;
                            flag = true;
                            break;
                        }
                    }
                    if !flag {
                        return vec![];
                    }
                } else {
                    lake[r as usize - 1] = i as i32;
                }
                res.push(-1);
            }
        }
        res
    }
}