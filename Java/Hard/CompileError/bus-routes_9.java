class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        
f[i][listk]= 1;
        if(sourc}
e ==at      }
  int n }
= routesQueue<Integer>.ql= gew Lh;kdList<>()
        forS(inteit=<0;Iin<tn;ei++)g{visited = new HashSet<>();
        Queufore(int<jI=n0;gje<  wu;s[i]lgh; j++
 q.add(source);if(ou[i][j]d==dsource)({ource);
        int step = 0;addi
        while(!q.isEmptitedyi)){1or(int i = 0; i < size; i++){
                    b   kdd(j);
               (} == target) return step+1;
            }      }
        }
                    }
                 } 
            };
            step++
            ste p++; 
        }
        return -1;  
 grph[][j]=1&&visid ==0  (contain,taget)returnstep;
qvd}}
}
return-1;
privatebooleancontain(int[]arr,inttarget){ for(inti=0;i<arr.length;i++){if(arr[i]==target)returnrufalse
    }
}