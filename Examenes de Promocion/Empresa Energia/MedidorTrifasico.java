    public class MedidorTrifasico extends Medidor{
        // instance variables - replace the example below with your own
        private CoordenadaGPS posicion;
        private TipoMedidor tipo_medidor;
    
        /**
         * Constructor for objects of class MedidorTrifasico
         */
        public MedidorTrifasico(CoordenadaGPS posicion)
        {
            // initialise instance variables
            super(posicion);
            this.tipo_medidor = TipoMedidor.TRIFASICO;
            
        }
    
        /**
         * 
         * @return El Tipo de Medidor
         */
        public TipoMedidor getTipoMedidor(){
            return tipo_medidor;
        }
        
        /**
         * 
         * @return El serialNumber del medidor
         */
        public int getSerialNumber() {
            return serialNumber;
        }
        
        @Override
        public void reset(){
            incrementarConsumo(0);
            serialNumber = 0;
        }
        
        @Override
        /**
         * Sobreescriba el metodo toString(), 
         * tal que agregue "_<tipoDeMedidor>"
         * @return La DESCRIPCION del Medidor
         */
        public String toString(){
            return "SN_"+ serialNumber + "_" + tipo_medidor;
        }
    }
