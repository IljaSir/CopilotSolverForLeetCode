impl Solution {
    pub fn component_value(nums: Vec<i32>, edges: Vec<Vec<i32>>) -> i32 {
        
        let mut res = 0;
        let mut sum = 0;
        let mut n = nums.len();
        let mut parents = vec![0; n];
        let mut sizes = vec![1; n];
        let mut values = vec![0; n];
        for i in 0..n {
            parents[i] = i as i32;
            values[i] = nums[i];
            sum += nums[i];
        }
        for edge in edges {
            let (i, j) = (edge[0] as usize, edge[1] as usize);
            let (pi, pj) = (Solution::find(&mut parents, i as i32), Solution::find(&mut parents, j as i32));
            if pi != pj {
                parents[pi as usize] = pj;
                sizes[pj as usize] += sizes[pi as usize];
                values[pj as usize] += values[pi as usize];
            }
        }
        for i in 0..n {
            if parents[i] == i as i32 {
                if values[i] != sum / sizes[i] {
                    return -1;
                }
                res += sizes[i] - 1;
            }
        }
        res
    }
    fn find(parents: &mut Vec<i32>, i: i32) -> i32 {
        if parents[i as usize] != i {
            parents[i as usize] = Solution::find(parents, parents[i as usize]);
        }
        parents[i as usize]
    }
}