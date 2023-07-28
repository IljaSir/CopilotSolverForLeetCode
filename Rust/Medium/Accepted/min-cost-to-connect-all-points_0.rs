impl Solution {
    pub fn min_cost_connect_points(points: Vec<Vec<i32>>) -> i32 {
        
        let n = points.len();
        let mut parent = vec![0; n];
        for i in 0..n {
            parent[i] = i;
        }
        let mut edges = vec![];
        for i in 0..n {
            for j in i+1..n {
                let d = (points[i][0] - points[j][0]).abs() + (points[i][1] - points[j][1]).abs();
                edges.push((d, i, j));
            }
        }
        edges.sort();
        let mut ans = 0;
        let mut num = n;
        for (d, i, j) in edges {
            if Self::find(&mut parent, i) != Self::find(&mut parent, j) {
                ans += d;
                Self::union(&mut parent, i, j);
                num -= 1;
                if num == 1 {
                    break;
                }
            }
        }
        ans
    }
    fn find(parent: &mut Vec<usize>, i: usize) -> usize {
        if parent[i] != i {
            parent[i] = Self::find(parent, parent[i]);
        }
        parent[i]
    }
    fn union(parent: &mut Vec<usize>, i: usize, j: usize) {
        let pi = Self::find(parent, i);
        let pj = Self::find(parent, j);
        if pi != pj {
            parent[pi] = pj;
        }
    }
}